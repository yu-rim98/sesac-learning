/* 
prompt / setPrompt : 사용자 입력 요소 입력값 상태 관리
onSubmit : form 제출 이벤트 핸들러 함수
isLoading : API 요청 후 응답 대기 상태(true / false)
*/
export default function ChatForm({ prompt, setPrompt, onSubmit, isLoading }) {
  return (
    <form onSubmit={onSubmit} className="flex-shrink-0 flex gap-2 p-4 mb-4">
      <input
        type="text"
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
        placeholder={
          isLoading ? "답변을 생성하고 있습니다..." : "메시지를 입력하세요..."
        }
        disabled={isLoading}
        className="flex-grow-1 px-3 py-2 border border-gray-300 "
      />
      <input
        type="submit"
        value="전송"
        disabled={isLoading || !prompt.trim()}
        className="px-4 py-2 border border-gray-300 cursor-pointer"
      />
    </form>
  );
}
