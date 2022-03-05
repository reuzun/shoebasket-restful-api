import React, { useState } from 'react'
import { DropdownButton, Dropdown, Container, Image, Button } from 'react-bootstrap'

export default function CartSummary() {

    const [show, setShow] = useState(false);
    const showDropdown = (e) => {
        setShow(!show);
    }
    const hideDropdown = e => {
        setShow(false);
    }

    return (
        <div>

            <DropdownButton variant="outline-light" id="dropdown-basic-button"
                title={<i class="bi bi-cart"></i>}
                show={show}
                onMouseEnter={showDropdown}
                onMouseLeave={hideDropdown}
            >
                <Dropdown.Item disabled href="#/action-1" style={{ display: "inline", maxHeight: "43px", margin: "2%", display: "flex", flexDirection: "row" }}>
                    <Image src="/heel.jpg" style={{ maxHeight: "33px" }} /> Kinetix - wcq4re - 605.28£
                </Dropdown.Item>
                <Button variant="danger" style={{ float: "right" }}>Remove</Button>
                <Dropdown.Item disabled href="#/action-1" style={{ display: "inline", maxHeight: "43px", margin: "2%", display: "flex", flexDirection: "row" }}>
                    <Image src="/heel.jpg" style={{ maxHeight: "33px" }} /> Puma - mhnzy - 332.38£
                </Dropdown.Item>
                <Button variant="danger" style={{ float: "right" }}>Remove</Button>

            </DropdownButton>

        </div>
    )
}
