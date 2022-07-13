const { faker } = require('@faker-js/faker');
const express = require("express");
const app = express();
const port = 8000;


//User Class//
const createUser = () => {
    const newUser = {
        firstName: faker.name.firstName(),
        lastName: faker.name.lastName(),
        email: faker.internet.exampleEmail(),
        password: faker.internet.password(20, true),
        phoneNumber: faker.phone.phoneNumber(),
        _id: faker.database.mongodbObjectId()
    };
    return newUser;
};
    
const newFakeUser = createUser();
console.log(newFakeUser);

//Company Class//

const createCompany = () => {
    const newCompany = {
        _id: faker.database.mongodbObjectId(),
        name: faker.company.companyName(),
        addressStreet: faker.address.streetName(),
        addressCity:faker.address.city(),
        addressState:faker.address.stateAbbr(),
        addressZip:faker.address.zipCode(), 
        addressCountry: faker.address.country()
    };
    return newCompany;
};
const newFakeCompany = createCompany();
console.log(newFakeCompany);


//routes//
app.get("/api", (req, res) => {
    res.json({ message: "Hello World" });
});

app.get("/api/users/new", (req, res) => {
    res.json(createUser())
});

app.get("/api/companies/new", (req, res) => {
    res.json(createCompany())
});

app.get("/api/user/company", (req, res) => {
    res.json({user:createUser(),company:createCompany()})
});


// this needs to be below the other code blocks
app.listen( port, () => console.log(`Listening on port: ${port}`) );
