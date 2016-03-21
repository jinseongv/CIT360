public void addStudent(ActionEvent event){
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
        
                Student s = newStudent("John","Smith","123 Fake St.");
        
                session.save(s);
        
                session.getTransaction().commit();
        
                s.clear();
                init();
         }