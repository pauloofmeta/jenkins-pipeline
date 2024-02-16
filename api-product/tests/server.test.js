const request = require('supertest');
const { app } = require('../src/server')

describe('Server Test', () => {
    it('should test server', async () => {
        const res = await request(app)
            .get('/')
            .send();

        expect(res.statusCode).toEqual(200);
        expect(res.body).toHaveProperty('result');
    })
});