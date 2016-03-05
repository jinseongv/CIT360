class onlinemealsellingsystem
     {
            public static void main(String[] args)
            {
              DinnerNowSystem dns =new DinnerNowSystem();
              Customer c = new Customer();
              Restaurent r = new Restaurent();
              Bank b = new Bank();

              c.addOrderItems();
              c.confirmOrder();
              dns.sendorder();
              c.payment();
              r.deliverfood();
           }
          }