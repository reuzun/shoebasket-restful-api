import React, { useState, useEffect } from 'react'
import { Card, Button, Container, Row, Col, Pagination } from 'react-bootstrap'
import ShoeService from '../services/ShoeService'
import Rating from "react-rating";


let renderImage = (type) => {
    if (type == "Heel") {
        return "heel.jpg";
    }
    else if (type == "Boot") {
        return "boot.jpg";
    }
    else if (type == "Sneaker") {
        return "sneaker.jpg";
    }
    return null;
}

export default function ShoeList() {

    const [models, setmodels] = useState([])


    useEffect(() => {
        let shoeService = new ShoeService();
        shoeService.getRandomShoes().then(result => {
            setmodels(result.data.data)
        })

    }, [])

    return (
        <div>
            <Container>
                <Row className="col">
                    {
                        models.map(e => (
                            <Col className="col-3">
                                <Card style={{ width: '15rem', marginRight: "15px", marginBottom: "15px" }}>
                                    <Card.Img style={{ maxWidth: "80px", maxHeight: "80px", minHeight: "80px", marginLeft: "80px" }} variant="top" src={renderImage(e.type)} />
                                    <Card.Body>
                                        <Card.Title>{e.brandName} - {e.modelName}</Card.Title>
                                        <Card.Text>
                                            Price : {e.price}£<br></br>
                                            <Rating readonly initialRating={e.customerRating}
                                                emptySymbol={<i class="bi bi-star"></i>}
                                                fullSymbol={<i class="bi bi-star-fill"></i>} /> {e.customerRating}
                                        </Card.Text>
                                        <Button variant="secondary">Details</Button>
                                        <Button variant="primary" style={{ marginLeft: "5px" }}>Add to Cart</Button>
                                    </Card.Body>
                                </Card>
                            </Col>
                        ))
                    }
                </Row>
            </Container>
            <Pagination style={{ marginLeft: "37.5%"  }}>
                <Pagination.First />
                <Pagination.Prev />
                <Pagination.Item active >{1}</Pagination.Item>
                <Pagination.Item  >{2}</Pagination.Item>
                <Pagination.Item  >{3}</Pagination.Item>
                <Pagination.Item  >{4}</Pagination.Item>
                <Pagination.Item  >{5}</Pagination.Item>
                <Pagination.Next />
                <Pagination.Last />
            </Pagination>
        </div>
    )
}

