import { Component, OnInit } from '@angular/core';
import { PayPalConfig, PayPalEnvironment, PayPalIntegrationType } from 'ngx-paypal';
import { Router, ActivatedRoute } from '@angular/router';
import { PlacanjeService } from 'src/app/service/placanje.service';

@Component({
  selector: 'app-paypal',
  templateUrl: './paypal.component.html',
  styleUrls: ['./paypal.component.css']
})
export class PaypalComponent implements OnInit {

  public payPalConfig?: PayPalConfig;
  //private secret: string;
  private secret ='Af6RrdeRgT1nP1NLcztzn0RoivQnFIBDii_C23gtxljFUuugYofl5Y0asUu8mtS6JA9Xg2_G0XncrJw9';
  private subtotal= 3.00;
  private tax= 0.05;
  private shipping= 0.00;
  private handling_fee= 0.00;
  private shipping_discount= 0.00;
  private insurance= 0.10;
  private total = this.subtotal + this.tax + this.shipping + this.handling_fee + this.shipping_discount + this.insurance;
  private success_url = "";
  private failure_url = "";
  private error_url = "";

  private id: string;
  private payPalData: any;


  constructor(private router: Router, private placanjeServcice: PlacanjeService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];  
    this.placanjeServcice.uzmiPodatkeZaPayPal(this.id).subscribe((data: any)=>{
      console.log(data);
      this.secret = data.secret;
      this.subtotal = data.kolicina;
      // this.success_url = data.successUrl;
      // this.failure_url = data.failedUrl;
      // this.error_url = data.errorUrl;
      
    });
    this.initConfig();
    
  }
  private initConfig(): void {
    this.payPalConfig = new PayPalConfig(
      PayPalIntegrationType.ClientSideREST,
      PayPalEnvironment.Sandbox,
      {
        commit: true,
        client: {
          sandbox:           
             this.secret
        },
        button: {
          label: 'paypal',
          layout: 'vertical'
        },
        onAuthorize: (data, actions) => {
          console.log('Authorize');
          return (undefined);
        },
        onPaymentComplete: (data, actions) => {
          console.log('OnPaymentComplete');
          this.router.navigate([this.success_url]);
        },
        onCancel: (data, actions) => {
          console.log('OnCancel');
        },
        onError: err => {
          console.log('OnError');
          this.router.navigate([this.error_url]);
        },
        onClick: () => {
          console.log('onClick');
        },
        validate: (actions) => {
          console.log(actions);
        },
        experience: {
          noShipping: true,
          brandName: 'Angular PayPal'
        },
        transactions: [
          {
            amount: {
              total: this.total,
              currency: 'USD',
              details: {
                subtotal: this.subtotal,
                tax: this.tax,
                shipping: this.shipping,
                handling_fee: this.handling_fee,
                shipping_discount: this.shipping_discount,
                insurance: this.insurance
              }
            },
            custom: 'Custom value',
            // item_list: {
            //   items: [
            //     {
            //       name: 'hat',
            //       description: 'Brown hat.',
            //       quantity: 5,
            //       price: 3,
            //       tax: 0.01,
            //       sku: '1',
            //       currency: 'USD'
            //     },
            //     {
            //       name: 'handbag',
            //       description: 'Black handbag.',
            //       quantity: 1,
            //       price: 15,
            //       tax: 0.02,
            //       sku: 'product34',
            //       currency: 'USD'
            //     }],
            //   shipping_address: {
            //     recipient_name: 'Brian Robinson',
            //     line1: '4th Floor',
            //     line2: 'Unit #34',
            //     city: 'San Jose',
            //     country_code: 'US',
            //     postal_code: '95131',
            //     phone: '011862212345678',
            //     state: 'CA'
            //   },
            // },
          }
        ],
        note_to_payer: 'Contact us if you have troubles processing payment'
      }
    );
  }

}
