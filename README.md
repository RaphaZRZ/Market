<h1>Market</h1>
> Status: DEVELOPMENT ⚠️


<h2>IMPORTANT(not implemented)</h2>
<p>
Go to application.properties and ensure that <code>spring.datasource.username=root</code> and
<code>spring.datasource.password=root</code> represent the correct username and password for your database.<br>
This project uses swagger documentation, to access it, open your browser and go
to: <a href="http://localhost:8080/swagger-ui/index.html">http://localhost:8080/swagger-ui/index.html</a> 
while the application is running. Make sure you're using the correct port, in this case it is "8080".
</p>

<h2>About the project</h2>
<p>
Market is an e-commerce platform. It allows users to insert, list, update and delete products available in the 
market. The system has four types of users: Owner, Manager, Stocker and Client.
</p>



<h2>Business Rules</h2>
<ul> 
    <li>All types of users have a first name, last name, username, CPF, email, password and type. The username, email, and CPF must be unique in the system. Therefore, the system allows only one registration with the same username, email, or CPF;</li>
    <li>Clients can only list products;</li>
    <li>Stockers can list and insert products;</li>
    <li>Managers can list, insert, and update products;</li>
    <li>Owners can list, insert, update, and delete products;</li>
</ul>


<h2>What I Have Learned</h2>
<ul>
  <li><strong>TITLE</strong>DESCRIPTION</li>
</ul>


<h2>Data to test the system(not implemented)</h2>
<p>
[<br>
    {
        "firstName": "Mary",<br>
        "lastName": "Brown",<br>
        "username": "MaryBrown",<br>
        "CPF": "84512678412",<br>
        "email": "mary@gmail.com",<br>
        "password": "maryPassword",<br>
        "userType": "CLIENT"<br>
    },<br><br>
    {
        "firstName": "Peter",<br>
        "lastName": "Smith",<br>
        "username": "PeterSmith",<br>
        "CPF": "21548796352",<br>
        "email": "peter@gmail.com",<br>
        "password": "peterPassword",<br>
        "userType": "STOCKER"<br>
    },<br><br>
    {
        "firstName": "Anna",<br>
        "lastName": "Taylor",<br>
        "username": "AnnaTaylor",<br>
        "CPF": "31745289654",<br>
        "email": "anna@gmail.com",<br>
        "password": "annaPassword",<br>
        "userType": "MANAGER"<br>
    },<br>
    {
        "firstName": "John",<br>
        "lastName": "Walker",<br>
        "username": "JohnWalker",<br>
        "CPF": "96321478523",<br>
        "email": "john@gmail.com",<br>
        "password": "johnPassword",<br>
        "userType": "OWNER"<br>
    }<br>
]
</p>
