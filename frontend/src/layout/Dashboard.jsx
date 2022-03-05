import React from 'react'
import CategoryFilter from './CategoryFilter'
import Navi from './Navi'
import ShoeList from '../pages/ShoeList'
import { Col, Container } from 'react-bootstrap'
import Footer from './Footer'

export default function Dashboard() {
    return (
        <div>
            <Navi />
            <Container fluid style={{ display: "flex", marginTop: "30px", paddingLeft: "4%" }}>
                <Col className='col-2'>
                    <CategoryFilter />
                </Col>
                <Col className='col-9'>
                    <ShoeList />
                </Col>
            </Container>
            <Footer/>
        </div>
    )
}
