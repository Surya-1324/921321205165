// AllProductsPage.js
import React, { useState, useEffect } from 'react';

import axios from 'axios';

import Navbar from './Navbar';
import ProductCard from './ProductCard';
import './AllProductspage.css'


function AllProductsPage() {
  const [products, setProducts] = useState([{
    id:1,
    link:"https://riseuplabs.com/blog/wp-content/uploads/2020/10/photo-editing-software.jpg",
    name: "Laptop 11",
        price: 5683.0,
        rating: 4.96,
    discount: 56,
        availability: "out-of-stock"
  },{
    id:2,
    link:"https://www.asus.com/media/Odin/Websites/global/Series/30.png",
    name: "Laptop 5",
        price: 1258.0,
        rating: 4.93,
    discount: 33,
        availability: "Yes"
  },
  {
    id:3,
    link:"https://m.media-amazon.com/images/I/61xllgmd5bL.jpg",
    name: "Laptop 4",
    price: 1258.0,
    rating: 4.93,
discount: 33,
    availability: "out-of-stock"
  }


]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get('http://localhost:8080/products?company=AMZ&category=Laptop&top=10&minPrice=10&maxPrice=10000');
        setProducts(response.data);
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };
    fetchProducts();
  }, []);

  return (
    <div>
        <Navbar />
        <h1>All Products</h1><br />
        <div className="product">
        
      {products.map((product) => (
        <ProductCard key={product.id} product={product}  link={product} />
      ))}
        </div>
        <div className="product">
        
        {products.map((product) => (
          <ProductCard key={product.id} product={product} />
        ))}
          </div>
      




    </div>
  );
}

export default AllProductsPage;
