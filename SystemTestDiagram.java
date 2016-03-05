 public boolean doValidateUser(String Password,String UserName)
       {
               loadAccountDetails();
               boolean bRet;
               if (Username==name)
               {
                       if (Password == password)
                       {
                               bRet = true;
                               bValidUser = true;
                       }
                       else
                       {
                               bRet = false;
                       }
 
               }
               else
               {
                       bRet = false;
               }
 
               return bRet;
       }
