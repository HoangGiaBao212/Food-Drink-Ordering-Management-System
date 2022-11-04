# Qui trình làm việc với team

## Thảo luận

Thảo luận trên mục discussions của github

## Sử dụng github
Tham khảo tại đây

https://viblo.asia/p/git-khai-luoc-ve-git-va-cach-su-dung-git-3P0lPP7olox

Hoặc

Lần đầu

```sh
git clone https://github.com/tnowad/Food-Drink-Ordering-Management-System.git
```
Sử dụng lệnh trên hoặc dùng vscode gõ F1 -> git clone -> paste

Khi code 1 người 1 nhánh

```sh
git pull
#Code
git add .
git commit -m "fix read file fail"
git push
```

Khi code 2 người 1 nhánh

```sh
git pull
#Code
git add .
git commit -m "fix read file fail"
git pull --rebase
git push
```

Sau khi code xong tính năng muốn merge về nhánh chính

```sh
git checkout main
git merge NhánhCủaBạn
```