import { useState, useEffect } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import { getPhoto, deletePhoto } from '../api/photoApi'

const IMAGE_BASE_URL = import.meta.env.VITE_IMAGE_URL || ''

function DetailPage() {
  const { id } = useParams()
  const navigate = useNavigate()
  const [photo, setPhoto] = useState(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const fetchPhoto = async () => {
      try {
        const data = await getPhoto(id)
        setPhoto(data)
      } catch (error) {
        console.error('Failed to fetch photo:', error)
        alert('사진을 찾을 수 없습니다')
        navigate('/')
      } finally {
        setLoading(false)
      }
    }
    fetchPhoto()
  }, [id, navigate])

  const handleDelete = async () => {
    if (!window.confirm('정말 삭제하시겠습니까?')) return
    
    try {
      await deletePhoto(id)
      navigate('/')
    } catch (error) {
      alert('삭제 실패')
    }
  }

  if (loading) {
    return <div>로딩 중...</div>
  }

  if (!photo) {
    return <div>사진을 찾을 수 없습니다</div>
  }

  return (
    <div className="detail-page">
      <div className="detail-actions">
        <button onClick={() => navigate('/')}>← 목록으로</button>
        <button onClick={handleDelete} className="delete-btn">삭제</button>
      </div>
      
      <div className="detail-content">
        <img src={`${IMAGE_BASE_URL}${photo.imageUrl}`} alt={photo.title} />
        <div className="detail-info">
          <h2>{photo.title}</h2>
          {photo.description && <p>{photo.description}</p>}
        </div>
      </div>
    </div>
  )
}

export default DetailPage
