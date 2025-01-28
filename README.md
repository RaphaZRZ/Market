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
Market is an e-commerce platform. It allows users to buy, list ,insert, update and delete products available in the 
market. The system has four types of users: Owner, Manager, Stocker and Client.
</p>


<h2>Business Rules</h2>
<ul> 
    <li>All types of users have a first name, last name, username, CPF, email, password and type. The username, email, 
        and CPF must be unique in the system. Therefore, the system allows only one registration with the same username, 
        email, or CPF;</li>
    <li>Validation for user fields
        <ul>
            <li><strong>First Name:</strong> Must not be null. Length should be between 3 and 20 characters.</li>
            <li><strong>Last Name:</strong> Must not be null. Length should be between 3 and 20 characters.</li>
            <li><strong>Username:</strong> Must not be null. Length should be between 3 and 50 characters. It must be unique in the system.</li>
            <li><strong>CPF:</strong> Must not be null. It must be unique in the system.</li>
            <li><strong>Email:</strong> Must not be null. It must be a valid email format and its length should be between 6 and 320 characters. The email must be unique in the system.</li>
            <li><strong>Password:</strong> Must not be null. Length should be between 6 and 60 characters.</li>
            <li><strong>User Type:</strong> Must not be null. The user type is an enumerated field representing the type of the user (e.g., CLIENT, STOCKER, MANAGER, OWNER).</li>
        </ul>
    </li>
    <li>All products have a name, brand, price and quantity</li>
    <li>Validation for product fields
        <ul>
            <li><strong>Name:</strong> Must not be null. Length should be between 3 and 60 characters.</li>
            <li><strong>Brand:</strong> Must not be null. Length should be between 3 and 60 characters.</li>
            <li><strong>Price:</strong> Must not be null. The value must be positive (greater than 0).</li>
            <li><strong>Quantity:</strong> Must not be null. It represents the available stock of the product.</li>
        </ul>
    </li>
    <li>Clients can buy and list products;</li>
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
