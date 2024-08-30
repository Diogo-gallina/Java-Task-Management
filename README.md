# Java-Task-Management

## STEPS TO RUN THE PROJECT
1. *Add envs config in application.properties*
  - Add your oracle database credentials
  - Add secret token "api.token.secret"
    
2. *Install maven dependencies*
   
3. *Run the code and test the routes specified below*
   - #### Public routes
     - POST - /users/signup
     - POST - /login
     - GET - /public/status
   - #### Private routes
     - POST - /tasks
     - GET - /tasks
     - PUT - /tasks/{taskId}
     - DELETE - /tasks/{taskId}
