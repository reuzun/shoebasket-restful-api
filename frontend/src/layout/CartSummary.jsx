import React, {useState} from 'react'
import { DropdownButton, Dropdown, Container, Image } from 'react-bootstrap'

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

            <DropdownButton variant="outline-light" id="dropdown-basic-button" title={<i class="bi bi-cart"></i>} show={show}
                onMouseEnter={showDropdown}
                onMouseLeave={hideDropdown}>
                <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                <Dropdown.Divider />
                <Dropdown.Item href="#/action-4">Separated link</Dropdown.Item>
            </DropdownButton>

        </div>
    )
}
