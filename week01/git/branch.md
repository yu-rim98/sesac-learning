# git branch

## 브랜치 명령어

### `git branch`

- 프로젝트의 git 브랜치 목록을 출력한다.

### `git branch <브랜치명>`

- 새로운 브랜치 생성

### `git switch <브랜치명>`

- 브랜치 이동

### `git branch -d <브랜치명>`

- 병합이 된 브랜치만 삭제

### `git branch -D <브랜치명>`

- 병합이 되지 않은 브랜치도 강제 삭제 (주의)

## 서브(기능) 브랜치 워크플로우

1. 브랜치 생성 : `git branch <브랜치명>`
2. 브랜치 전환 : `git switch <브랜치명>`
3. 작업
4. `git add .`
5. `git commit -m "커밋 메시지"
6. 브랜치 전환 : `git switch main`
7. 브랜치 병합 : `git merge <브랜치명>`
8. (선택) 브랜치 삭제 : `git branch -d <브랜치명>`
