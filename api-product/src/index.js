const { app } = require('./server');

const port = 3000;

app.listen(port, () => {
    console.log(`Server runing on port: ${port}`);
});