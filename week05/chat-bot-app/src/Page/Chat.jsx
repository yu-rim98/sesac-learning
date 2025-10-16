import React from "react";
import { chat, config } from "../utils/genai";
import { useState } from "react";
import MessageList from "../components/MessageList";
import ChatForm from "../components/ChatForm";

// 기본 컨텐츠 생성형 AI
export default function Chat() {
  const [prompt, setPrompt] = useState(""); // 사용자 입력 프롬프르 관리 상태
  const [messages, setMessages] = useState([]); // 사용자 - AI 대화 내역 관리 상태
  const [isLoading, setIsLoading] = useState(false); // AI 요청 대기 상태

  async function handleSubmit(e) {
    e.preventDefault();

    if (isLoading || !prompt.trim()) {
      // AI 답변 로딩 중이 거나 사용자가 입력하지 않은 경우에는 작업 X
      return;
    }

    // 대화 내역 상태 업데이트
    // 사용자의 프롬프트를 대화 내역에 추가
    setMessages((prev) => [...prev, { role: "user", content: prompt }]);

    const currentPrompt = prompt;

    // 사용자 입력 프롬프트 초기화
    setPrompt("");

    // 요청을 보내니까 로딩 상태 true
    setIsLoading(true);

    await generateAiContent(currentPrompt);

    // 요청을 보낸 후니까 로딩 상태 flase
    setIsLoading(false);
  }

  // AI 요청 및 응답 생성 함수
  async function generateAiContent(currentPrompt) {
    try {
      // ai 객체를 이용해 단순 텍스트 생성
      const response = await chat.sendMessage({
        // contents(프롬프트)
        message: currentPrompt,
        config: config,
      });
      console.log(response.data);

      // messages 상태에 AI 응답 저장
      setMessages((prev) => [...prev, { role: "ai", content: response.text }]);
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      {/* 사용자 - AI 대화 내용 출력 컴포넌트 */}
      <MessageList messages={messages} />

      {/* 사용자의 프롬프트 작성 폼 컴포넌트 */}
      <ChatForm
        prompt={prompt} // 사용자 입력 값
        setPrompt={setPrompt} // 사용자 입력 값 세터 함수
        isLoading={isLoading} // AI 요청 대기 상태
        onSubmit={handleSubmit} // 입력 제출 시 이벤트 핸들러 함수
      />
    </>
  );
}
