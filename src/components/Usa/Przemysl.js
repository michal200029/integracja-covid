import { Button } from '@mui/material';
import React, { Component } from 'react';
import { Card, Col, Row, Stack } from 'react-bootstrap';
import Navbar from "../Navbar.js";
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import styled from '@emotion/styled';
import axios from 'axios';
export class Prze extends Component {
    constructor(props) {
        super(props);
        this.state = {
            token: localStorage.getItem("token"),
            values: [],
            beginDateYear: "2019",
            endDateYear: "2019",
            beginDateMonth: "01",
            endDateMonth: "01",
            feb: {date: "", employees: 1},
            apr: {date: "", employees: 1}
        }
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(){
        const headers = { 
            'Authorization': "Bearer " + this.state.token
        };
        axios.post(`http://localhost:8080/usa/manufacturing`,{
            startDate:"2020-01-01",
            endDate:"2020-08-01"
        },{headers})
        .then(res => {this.setState({values : res.data.data})
        if(this.state.values[0]?.date)
        {
            this.setState({feb:this.state.values[1]})
            this.setState({apr:this.state.values[3]})
        }
    }) 
    }

    render() {
        if (this.state.token !== null) {
            const { values, feb, apr } = this.state
            return (
                <>
                    <Navbar />
                    <Row xs={1} md={2} className="justify-content-md-center">
                        <Col>
                            <Card className="center">
                                <Card.Img src="https://www.obserwatorfinansowy.pl/wp-content/uploads/2015/10/usa-praca-fabryka-CC-By-NC-nikzane.jpg" />
                                <Card.Title>Produkcja w USA</Card.Title>
                                <Card.Body>
                                    <Card.Text>Podstawą gospodarczej potęgi Stanów Zjednoczonych jest bardzo dobrze rozwinięty przemysł. Jego wszechstronności i nowoczesności sprzyjają: bogata i zróżnicowana baza surowcowa, wysoko wykwalifikowana siła robocza oraz ustrój społeczno-gospodarczy (gospodarka rynkowa). Szansę rozwoju mają zakłady produkujące wyroby tanie i o wysokiej jakości.</Card.Text>
                                </Card.Body>
                                <Stack>
                                    <Button href='/' color="error" size="medium" type="submit" variant="contained">
                                        Powrót do strony głównej
                                    </Button>
                                </Stack>
                            </Card><br />
                        </Col>
                    </Row>
                    <Row xs={1} md={2} className="justify-content-md-center">
                        <Col>
                            <Card className="center">
                                <Card.Title>Podaj date początkową i końcową dla danych które chcesz wyświetlić</Card.Title>
                                <Card.Body>
                                    <form>
                                        <Table>
                                            <thead>
                                                <tr>
                                                    <th />
                                                    <th>Data początkowa</th>
                                                    <th>Data końcowa</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Rok</td>
                                                    <td>
                                                        <select value={this.state.beginDateYear} onChange={(event) => { this.setState({ beginDateYear: event.target.value }) }}>
                                                            <option value="2015">2015</option>
                                                            <option value="2016">2016</option>
                                                            <option value="2017">2017</option>
                                                            <option value="2018">2018</option>
                                                            <option value="2019">2019</option>
                                                            <option value="2020">2020</option>
                                                            <option value="2021">2021</option>
                                                            <option value="2022">2022</option>
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <select value={this.state.endDateYear} onChange={(event) => { this.setState({ endDateYear: event.target.value }) }}>
                                                            <option value="2015">2015</option>
                                                            <option value="2016">2016</option>
                                                            <option value="2017">2017</option>
                                                            <option value="2018">2018</option>
                                                            <option value="2019">2019</option>
                                                            <option value="2020">2020</option>
                                                            <option value="2021">2021</option>
                                                            <option value="2022">2022</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Miesiąc</td>
                                                    <td>
                                                        <select value={this.state.beginDateMonth} onChange={(event) => { this.setState({ beginDateMonth: event.target.value }) }}>
                                                        {this.state.beginDateYear==="2022" &&
                                                            <>
                                                                <option value="01">Styczeń</option>
                                                                <option value="02">Luty</option>
                                                                <option value="03">Marzec</option>
                                                                <option value="04">Kwiecień</option>
                                                                <option value="05">Maj</option>
                                                                </>
                                                            }
                                                            {this.state.beginDateYear!=="2022" &&
                                                                <>
                                                                <option value="01">Styczeń</option>
                                                            <option value="02">Luty</option>
                                                            <option value="03">Marzec</option>
                                                            <option value="04">Kwiecień</option>
                                                            <option value="05">Maj</option>
                                                            <option value="06">Czerwiec</option>
                                                            <option value="07">Lipiec</option>
                                                            <option value="08">Sierpień</option>
                                                            <option value="09">Wrzesień</option>
                                                            <option value="10">Październik</option>
                                                            <option value="11">Listopad</option>
                                                            <option value="12">Grudzień</option>
                                                                </>
                                                            } 
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <select value={this.state.endDateMonth} onChange={(event) => { this.setState({ endDateMonth: event.target.value }) }}>
                                                            {this.state.endDateYear==="2022" &&
                                                            <>
                                                                <option value="01">Styczeń</option>
                                                                <option value="02">Luty</option>
                                                                <option value="03">Marzec</option>
                                                                <option value="04">Kwiecień</option>
                                                                <option value="05">Maj</option>
                                                                </>
                                                            }
                                                            {this.state.endDateYear!=="2022" &&
                                                                <>
                                                                <option value="01">Styczeń</option>
                                                            <option value="02">Luty</option>
                                                            <option value="03">Marzec</option>
                                                            <option value="04">Kwiecień</option>
                                                            <option value="05">Maj</option>
                                                            <option value="06">Czerwiec</option>
                                                            <option value="07">Lipiec</option>
                                                            <option value="08">Sierpień</option>
                                                            <option value="09">Wrzesień</option>
                                                            <option value="10">Październik</option>
                                                            <option value="11">Listopad</option>
                                                            <option value="12">Grudzień</option>
                                                                </>
                                                            } 
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td rowSpan={3}><input type="submit" onClick={this.handleSubmit} value="Wyślij" /></td>
                                                </tr>

                                            </tbody>
                                        </Table>
                                    </form>
                                </Card.Body>
                            </Card><br />
                        </Col>
                        <Col>
                            <Card className="center">
                                <Card.Title>Wykres </Card.Title>
                                <Card.Body>
                                    <LineChart width={600} height={300} data={values} margin={{ top: 5, right: 20, bottom: 5, left: 15 }}>
                                        <Line type="monotone" dataKey="employees" stroke="#8884d8" />
                                        <CartesianGrid stroke="#ccc" strokeDasharray="5 5" />
                                        <XAxis dataKey="date" />
                                        <YAxis domain={[11000000,13500000]}/>
                                        <Tooltip />
                                    </LineChart>
                                </Card.Body>
                            </Card><br />
                        </Col>
                    </Row>
                    <Row xs={1} md={2} className="justify-content-md-center">
                        <Col>
                            <Card className="center">
                                <Card.Title>Tabela </Card.Title>
                                <Card.Body>

                                    <TableContainer component={Paper}>
                                        <Table sx={{ minWidth: 650 }} aria-label="simple table">
                                            <TableHead>
                                                <StyledTableRow>
                                                    <StyledTableCell align="center">Data</StyledTableCell>
                                                    <StyledTableCell align="center">Wartość</StyledTableCell>
                                                </StyledTableRow>
                                            </TableHead>
                                            <TableBody>
                                                {
                                                    values.map(d => (
                                                        <TableRow
                                                            key={d.date}
                                                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                                        >
                                                            <TableCell component="th" scope="row" align="center">
                                                                {d.date}
                                                            </TableCell>
                                                            <TableCell align="center">{d.employees}</TableCell>
                                                        </TableRow>
                                                    )
                                                    )
                                                }
                                            </TableBody>
                                        </Table>
                                    </TableContainer>

                                </Card.Body>
                            </Card><br />
                        </Col>
                        <Col>
                            <Card className="center">
                                <Card.Title>Tabela przedstawiająca największy skok wartości występujący między lutym a kwietniem (wybuch pandemii)</Card.Title>
                                <Card.Body>
                                    <TableContainer component={Paper}>
                                        <Table sx={{ minWidth: 700 }} aria-label="spanning table">
                                            <TableHead>
                                                <TableRow>
                                                    <StyledTableCell />
                                                    <StyledTableCell align="center"> Luty</StyledTableCell>
                                                    <StyledTableCell align="center">Kwiecień</StyledTableCell>
                                                </TableRow>
                                            </TableHead>
                                            <TableBody>
                                                <StyledTableRow>
                                                    <TableCell align="center">Data</TableCell>
                                                    <TableCell align="center">{feb.date}</TableCell>
                                                    <TableCell align="center">{apr.date}</TableCell>
                                                </StyledTableRow>
                                                <StyledTableRow>
                                                    <TableCell align="center">Wartość</TableCell>
                                                    <TableCell align="center">{feb.employees}</TableCell>
                                                    <TableCell align="center">{apr.employees}</TableCell>
                                                </StyledTableRow>
                                                <TableRow>
                                                    <TableCell rowSpan={3} />
                                                    <TableCell align="center" >Różnica w wartościach</TableCell>
                                                    <TableCell align="center">{(feb.employees - apr.employees)}</TableCell>
                                                </TableRow>
                                                <TableRow>
                                                    <TableCell align="center">Procentowy ubytek</TableCell>
                                                    <TableCell align="center">{((1 - (apr.employees / feb.employees)) * 100).toFixed(2)}%</TableCell>
                                                </TableRow>
                                            </TableBody>
                                        </Table>
                                    </TableContainer>

                                </Card.Body>
                            </Card>
                        </Col>
                    </Row>
                </>
            );
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        var end = [this.state.endDateYear, this.state.endDateMonth, "01"].join('-');
        var start=[this.state.beginDateYear, this.state.beginDateMonth, "01"].join('-');
        var help = end;
        if(this.state.endDateYear<this.state.beginDateYear)
        {
            end = start;
            start= help;
            window.alert("Pomyliłeś daty, wydaje mi się że powinno być na odwrót");
        }
        if(this.state.endDateYear===this.state.beginDateYear && parseInt(this.state.endDateMonth)<parseInt(this.state.beginDateMonth))
        {
            end = start;
            start= help;
            window.alert("Pomyliłeś daty, wydaje mi się że powinno być na odwrót");
        }
        const headers = { 
            'Authorization': "Bearer " + this.state.token
        };
        axios.post(`http://localhost:8080/usa/manufacturing`,{
            startDate:start,
            endDate:end
        },{headers})
        .then(res => {this.setState({values : res.data.data})});
        this.setState(this.state);
    }
}
const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: 'black',
        color: 'white',
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: 14,
    },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
        backgroundColor: 'beige',
    },
    '&:nth-of-type(even)': {
        backgroundColor: 'beige',
    },
    // hide last border
    '&:last-child td, &:last-child th': {
        border: 0,
        backgroundColor: 'grey',
    },
}));