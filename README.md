# AlgoCrack

## Introduction
AlgoCrack 是一個仿造 Leetcode 的網站，用於學習大型系統設計。

## Feature
TODO

## Architecture
![image](https://github.com/emberow/blog-image/blob/main/BlogImg/AlgoCrack%E6%9E%B6%E6%A7%8B.png?raw=true)

- AlgoCrack Frontend: 服務前端。
- AlgoCrack-backend: BFF (Backend For Frontend)，聚合其他服務的 API。
- gateway: 使用 k8s ingress 來做 gateway: 並串接 google Oauth2。
- solution-service: 可以向 GPT 取得解答，也可以上傳自己的解答與他人分享。
- code-runner-service: 執行使用者程式碼，使用 k8s 來產生一個 job，執行完程式碼後回傳結果，並關閉 job。
- submission: 可以取得程式碼執行結果，以及使用者統計資料。
- problem-service: 使用者可以增刪改查題目。
- redis: 用於快取。
- postgres: 用於持久化資料。
- chatgpt: 會加上適當 prompt，來詢問 LLM 解題流程，也可以換成其他 LLM。

## Project Management
https://github.com/orgs/AlgoCrack/projects/5

## run Project
```bash
# use node v20
$ cd algo-crack-backend
$ yarn install
$ yarn run build
$ yarn run start
```

## CLI Lint check
```bash
yarn run lint
```

## unit test
``` bash
yarn run test
```

## swagger
[http://localhost:3000/api](http://localhost:3000/api)
