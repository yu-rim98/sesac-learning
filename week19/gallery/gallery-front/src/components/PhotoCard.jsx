import { useNavigate } from 'react-router-dom'

const IMAGE_BASE_URL = import.meta.env.VITE_IMAGE_URL || ''

function PhotoCard({ photo }) {
  const navigate = useNavigate()

  return (
    <div className="photo-card" onClick={() => navigate(`/photos/${photo.id}`)}>
      <img src={`${IMAGE_BASE_URL}${photo.imageUrl}`} alt={photo.title} />
      <div className="photo-info">
        <h3>{photo.title}</h3>
      </div>
    </div>
  )
}

export default PhotoCard
