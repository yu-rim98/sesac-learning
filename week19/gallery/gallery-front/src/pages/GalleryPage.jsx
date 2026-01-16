import { useState, useEffect } from 'react'
import { getPhotos } from '../api/photoApi'
import PhotoCard from '../components/PhotoCard'
import UploadForm from '../components/UploadForm'

function GalleryPage() {
  const [photos, setPhotos] = useState([])
  const [loading, setLoading] = useState(true)

  const fetchPhotos = async () => {
    try {
      const data = await getPhotos()
      setPhotos(data)
    } catch (error) {
      console.error('Failed to fetch photos:', error)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchPhotos()
  }, [])

  if (loading) {
    return <div>로딩 중...</div>
  }

  return (
    <div className="gallery-page">
      <UploadForm onUploadSuccess={fetchPhotos} />
      
      <div className="photo-grid">
        {photos.length === 0 ? (
          <p>사진이 없습니다. 첫 번째 사진을 업로드하세요!</p>
        ) : (
          photos.map((photo) => (
            <PhotoCard key={photo.id} photo={photo} />
          ))
        )}
      </div>
    </div>
  )
}

export default GalleryPage
