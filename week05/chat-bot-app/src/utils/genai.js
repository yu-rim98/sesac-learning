import { GoogleGenAI } from "@google/genai";

// 환경변수 API 키
const GEMINI_API_KEY = import.meta.env.VITE_GEMINI_API_KEY;

// AI 객체 생성
const ai = new GoogleGenAI({ apiKey: GEMINI_API_KEY });

// AI Chat 객체 생성 - 사용자를 기억할 수 있게
const chat = ai.chats.create({
  model: "gemini-2.5-flash",
});

const responseSchema = {
  type: "object", // 객체 타입으로 응답하도록 설정
  properties: {
    // 객체의 속성들
    isMemo: {
      type: "boolean",
      description: "할 일, 메모, 업무, 계획 등 관련 여부",
    },
    content: {
      type: "string",
      description: "할 일 내용 (본문)",
    },
    createdate: {
      type: "string",
      description: "할 일 등록 날짜(YYYY-MM-DD)",
    },
    dueDate: {
      type: "string",
      description: "할 일 마감 기한(YYYY-MM-DD)",
    },
  },
  required: ["isMemo", "content", "dueDate"], // 응답 필수 속성 지정
  additionalProperties: false,
};

const systemInstruction = [
  `오늘 날짜: ${new Date().toISOString().split("T")[0]}`,
  "당신은 할 일 관리 AI입니다. 오직 할 일이나 업무 관련 내용만 처리합니다.",
  "'마감 기한', '해야할 일', '간단한 메모' 형식의 질문이 아니면 '마감 기한', '해야할 일', '간단한 메모' 형식으로 질문하라고 답변합니다.",
  "올바른 사용자 입력에만 JSON 형식으로 응답합니다.",
  "일반적인 대화, 인사, 질문은 무시하고, 할 일이 아닌 경우에는 isMemo를 false로 설정합니다.",
  "사용자의 질문을 이해할 수 없는 경우에는 isMemo를 false로 설정합니다.",
  "응답할 때는 할 일 내용, 등록 날짜, 마감 날짜, 우선 순위, 할 일 종류를 포함한 객체를 생성합니다.",
];

// 응답 파라미터 설정
const config = {
  responseMimeType: "application/json", // 응답 형식 (JSON 타입으로 응답하도록)
  responseJsonSchema: responseSchema, // 응답 JSON 구조 - 위에 정의한 구조로
  systemInstruction: systemInstruction, // 프롬프트 설정
};

// const config = {
//   // AI 모델의 응답 특성을 조절하는 값
//   temperature: 1, // 1에 가까울수록 창의적, 0에 가까울수록 고정된 답변
//   maxOutputTokens: 1500, // 응답 최대 토큰 수 (최대 8192?)
//   stopSquences: "\\n\\n",

//   // 시스템 지침 속성 - 모델의 역할, 규칙을 지정하는 프롬프트
//   // 해당 AI를 사용하는 목적 등에 맞게 답변을 할 수 있도록 프롬프트를 설정하는 곳
//   systemInstruction: [
//     "너는 일정 계획 전문가야.",
//     "'실행 날짜', '해야할 일', '간단한 메모' 형식의 질문이 아니면 '실행 날짜', '해야할 일', '간단한 메모' 형식으로 질문하라고 답변해",
//   ],
// };

export { ai, chat, config };
