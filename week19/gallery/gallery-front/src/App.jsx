import { BrowserRouter, Routes, Route } from 'react-router-dom'
import GalleryPage from './pages/GalleryPage'
import DetailPage from './pages/DetailPage'
import './App.css'

function App() {
  return (
    <BrowserRouter>
      <div className="app">
        <header>
          <h1>Photo Gallery</h1>
        </header>
        <main>
          <Routes>
            <Route path="/" element={<GalleryPage />} />
            <Route path="/photos/:id" element={<DetailPage />} />
          </Routes>
        </main>
      </div>
    </BrowserRouter>
  )
}

export default App
