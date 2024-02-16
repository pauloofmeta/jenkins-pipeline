FROM node:lts-alpine

# set maintainer
LABEL maintainer "pauloss@ciandt.com"

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY package.json .
RUN yarn install --production

COPY src/ .

HEALTHCHECK --interval=5s \
            --timeout=5s \
            CMD curl -f http://127.0.0.1:3000 || exit 1

EXPOSE 3000
CMD ["yarn", "start"]