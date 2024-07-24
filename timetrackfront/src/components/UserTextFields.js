import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper } from '@material-ui/core';

export default function UserTextFields() {
    const paperStyle = {padding: '40px 20px', width: 1200, margin: '20px auto'};
  
    return (
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <Box
            component="form"
            sx={{
              '& > :not(style)': { m: 1 },
            }}
            noValidate
            autoComplete="off"
          >
            {/* <TextField id="id" label="Id" variant="filled" /> */}
            <TextField id="first-name" label="FirstName" variant="filled" />
            <TextField id="last-name" label="LastName" variant="filled" />
            <TextField id="email" label="Email" variant="filled" />
            <TextField id="average-rate" label="Average Rate" variant="filled" />
            <TextField id="creation-date" label="Creation Date" variant="filled" />
          </Box>
        </Paper>
      </Container>
    );
  }
