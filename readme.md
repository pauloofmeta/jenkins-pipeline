# Jenkins Pipeline for Node.js Application

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## Description

This project is an example of implementing a pipeline using Jenkins for a Node.js application. It contains the following steps:

1. Install dependencies
2. Test
3. Build
4. Quality gate
5. Build Docker image of the project

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Installation

To get started with this project, follow the steps below:

1. Clone the repository to your local machine.
2. Requires docker installed.
3. Runing containers:

    ```shell
    docker compose up -d
    ```
4. Install the required dependencies by running the following command:

   ```shell
   cd ./api-product
   yarn
   ```

## License

This project is licensed under the [MIT License](LICENSE).
