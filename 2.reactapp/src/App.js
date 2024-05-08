import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import AllProductsPage from './AllProductspage';
import ProductDetailsPage from './ProductDetailsPage';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<AllProductsPage />} />
          <Route path="/products/:productId" element={<ProductDetailsPage/>} />
        </Routes>
      </div>
    </BrowserRouter>
    </div>
  );
}

export default App;
