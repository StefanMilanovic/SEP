import { Component, OnInit } from '@angular/core';
import { PayPalConfig, PayPalEnvironment, PayPalIntegrationType } from 'ngx-paypal';
import { Router } from '@angular/router';

@Component({
  selector: 'app-opcije-placanja',
  templateUrl: './opcije-placanja.component.html',
  styleUrls: ['./opcije-placanja.component.css']
})
export class OpcijePlacanjaComponent implements OnInit {
  
  public payPalConfig?: PayPalConfig;
  private secret = 'Af6RrdeRgT1nP1NLcztzn0RoivQnFIBDii_C23gtxljFUuugYofl5Y0asUu8mtS6JA9Xg2_G0XncrJw9';
  private subtotal= 3.00;
  private tax= 0.05;
  private shipping= 0.00;
  private handling_fee= 0.00;
  private shipping_discount= 0.00;
  private insurance= 0.10;
  private total = this.subtotal + this.tax + this.shipping + this.handling_fee + this.shipping_discount + this.insurance;

  constructor(private router: Router) { }

  ngOnInit() {
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
          //this.router.navigate(['https://www.google.rs/']);
          this.router.navigate(['uspesno']);
        },
        onCancel: (data, actions) => {
          console.log('OnCancel');
         // this.router.navigate(['http://www.google.rs/']);
         // window.location.href = 'http://www.google.rs/';
        },
        onError: err => {
          console.log('OnError');
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
              //total: 30.11,
              total: this.total,
              currency: 'USD',
              // details: {
              //   subtotal: 30.00,
              //   tax: 0.07,
              //   shipping: 0.03,
              //   handling_fee: 1.00,
              //   shipping_discount: -1.00,
              //   insurance: 0.01
              // }
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
