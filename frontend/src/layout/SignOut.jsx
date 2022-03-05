import React from 'react'
import { Button } from 'react-bootstrap'

export default function SignOut() {
    return (
        <div>
            <Button>
                Log In
            </Button>
            <Button variant="secondary" style={{ marginLeft: "15px" }}>
                Register
            </Button>
        </div>
    )
}
