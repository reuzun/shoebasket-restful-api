import React, { useState, useEffect } from 'react'
import { Card, Button, Container, Row, Col } from 'react-bootstrap'
import ShoeService from '../services/ShoeService'

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
                                    <Card.Img style={{ maxWidth: "80px", maxHeight: "80px", minHeight: "80px", marginLeft: "70px" }} variant="top" src={renderImage(e.type)} />
                                    <Card.Body>
                                        <Card.Title>{e.brandName} - {e.modelName}</Card.Title>
                                        <Card.Text>
                                            Price : {e.price}                                            
                                        </Card.Text>
                                        <Button variant="secondary">Details</Button>
                                        <Button variant="primary" style={{marginLeft: "5px"}}>Add to Cart</Button>
                                    </Card.Body>
                                </Card>
                            </Col>
                        ))
                    }
                </Row>
                <span style={{fontSize : ".4em", fontWeight : "lighter"}}>*To see available colors and numbers press details button.</span>
            </Container>
        </div>
    )
}

