import React, { useState, useEffect } from 'react';
import './ProductCard.css'
import { Link } from 'react-router-dom'

function ProductCard({product}) {
  return (
    <div>
        <div className="card">
        <img src={product.link}  height="100px" width="100px" alt="" /><br />
        <div className="details">
        <p> productName: {product.name} </p>
       <p> price: {product.price},</p>
        <p>rating: {product.rating}</p>
        <p> discount: {product.discount}</p>
       <p>availability: {product.availability}</p>
        


       <Link to={`/product/${product.id}`} className="about">
                <button className='button'>buy</button>
            </Link>
        <br/>
        </div>
        
        </div>
    </div>
  )
}

export default ProductCard