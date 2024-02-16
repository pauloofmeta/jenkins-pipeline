const express = require('express');
const app = express();

app.get('/', (_, res) => 
    res.status(200).send({ result: 'Server OK!!' }));

app.get('/api/user', (_, res) =>
	res.status(200).send({ name: "Test User", id: 9999 }));

module.exports = {
    app
};
