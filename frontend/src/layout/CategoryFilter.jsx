import React, { useState } from 'react';
import { InputGroup, ListGroup, Form, Range, Button } from 'react-bootstrap'
import RangeSlider from 'react-bootstrap-range-slider';

export default function CategoryFilter() {

    const [minPriceValue, setMinPriceValue] = useState(0);
    const [maxPriceValue, setMaxPriceValue] = useState(0);

    return (
        <div>
            <Form>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Search</Form.Label>
                    <Form.Control type="email" placeholder="Search..." />
                </Form.Group>
            </Form>
            <hr></hr>
            <Form>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Model Name</Form.Label>
                    <Form.Control type="text" placeholder="Model Name" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Brand Name</Form.Label>
                    <Form.Control type="text" placeholder="Brand Name" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Color</Form.Label>
                    <Form.Control type="text" placeholder="Color" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Number</Form.Label>
                    <Form.Control type="text" placeholder="Number" />
                </Form.Group>
                <hr></hr>
                <Form.Label>Type</Form.Label>
                <Form.Select aria-label="Default select example" placeholder='Type'>
                    <option value="-1"> </option>
                    <option value="1">Heel</option>
                    <option value="2">Sneaker</option>
                    <option value="3">Boot</option>
                </Form.Select>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1" style={{ marginTop: "25px" }}>
                    <Form.Label>Minimum Price - {minPriceValue}£</Form.Label>
                    <RangeSlider
                        value={minPriceValue}
                        onChange={changeEvent => setMinPriceValue(changeEvent.target.value)}
                        max="10000"
                        onAfterChange={e => e.target.value > maxPriceValue ? setMinPriceValue(maxPriceValue) : setMinPriceValue(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Maximum Price - {maxPriceValue}£</Form.Label>
                    <RangeSlider
                        value={maxPriceValue}
                        onChange={changeEvent => setMaxPriceValue(changeEvent.target.value)}
                        max="10000"
                        onAfterChange={e => e.target.value < minPriceValue ? setMaxPriceValue(minPriceValue) : setMaxPriceValue(e.target.value)}
                    />
                </Form.Group>
                <div className="d-grid gap-2">
                    <Button variant="outline-success" size="lg" >Search</Button>
                </div>
            </Form>
        </div>
    )
}
