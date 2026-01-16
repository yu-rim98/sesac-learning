# Photo Gallery Frontend

Photo Gallery 프로젝트의 React 프론트엔드입니다.

## 사전 요구사항

- Node.js 18+
- 백엔드 서버 실행 중 (gallery-back)
- DB 컨테이너 실행 중

## 설치 및 실행

```bash
npm install
npm run dev
```

브라우저에서 http://localhost:5173 접속

## 환경변수

`.env` 파일:
```
VITE_API_URL=http://localhost:8080/api
VITE_IMAGE_URL=http://localhost:8080
```

## 프로젝트 구조

```
src/
├── api/
│   └── photoApi.js       # API 호출 함수
├── components/
│   ├── PhotoCard.jsx     # 사진 카드 컴포넌트
│   └── UploadForm.jsx    # 업로드 폼 컴포넌트
├── pages/
│   ├── GalleryPage.jsx   # 갤러리 목록 페이지
│   └── DetailPage.jsx    # 사진 상세 페이지
├── App.jsx
└── App.css
```

## 기능

- 사진 목록 조회
- 사진 업로드 (제목, 설명, 이미지)
- 사진 상세 보기
- 사진 삭제
