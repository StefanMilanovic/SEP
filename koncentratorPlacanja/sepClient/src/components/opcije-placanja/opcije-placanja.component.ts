import { Component, OnInit } from '@angular/core';
import { PayPalConfig, PayPalEnvironment, PayPalIntegrationType } from 'ngx-paypal';

@Component({
  selector: 'app-opcije-placanja',
  templateUrl: './opcije-placanja.component.html',
  styleUrls: ['./opcije-placanja.component.css']
})
export class OpcijePlacanjaComponent implements OnInit {
  
  public payPalConfig?: PayPalConfig;
  constructor() { }

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
             //'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R'
             //'AFswfly.YIN965eEkMLCIj4Nbu3zA4cO3qfflMIKQa7THSVczFK3SlpP'
             'Af6RrdeRgT1nP1NLcztzn0RoivQnFIBDii_C23gtxljFUuugYofl5Y0asUu8mtS6JA9Xg2_G0XncrJw9'
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
        },
        onCancel: (data, actions) => {
          console.log('OnCancel');
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
              total: 30.11,
              currency: 'USD',
              details: {
                subtotal: 30.00,
                tax: 0.07,
                shipping: 0.03,
                handling_fee: 1.00,
                shipping_discount: -1.00,
                insurance: 0.01
              }
            },
            custom: 'Custom value',
            item_list: {
              items: [
                {
                  name: 'hat',
                  description: 'Brown hat.',
                  quantity: 5,
                  price: 3,
                  tax: 0.01,
                  sku: '1',
                  currency: 'USD'
                },
                {
                  name: 'handbag',
                  description: 'Black handbag.',
                  quantity: 1,
                  price: 15,
                  tax: 0.02,
                  sku: 'product34',
                  currency: 'USD'
                }],
              shipping_address: {
                recipient_name: 'Brian Robinson',
                line1: '4th Floor',
                line2: 'Unit #34',
                city: 'San Jose',
                country_code: 'US',
                postal_code: '95131',
                phone: '011862212345678',
                state: 'CA'
        
            },
          },
          }
        ],
        note_to_payer: 'Contact us if you have troubles processing payment'
      }
    );
  }
}
