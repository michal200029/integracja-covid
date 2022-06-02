import Navbar from "./Navbar.js";
import { Button } from '@mui/material';
import { Component } from "react";
import { Card, Col, Row, Stack } from "react-bootstrap";
import axios from "axios";

export class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            token: localStorage.getItem("token"),
        }
    }

    render() {
        return (
            <>
                <Navbar />
                {this.state.token !== null &&
                    <Row xs={1} md={3}>
                        <Col>
                            <Card>
                                <Card.Body>
                                    <Card.Img src="https://media.cinkciarz.pl/grafiki/waluty-na-swiecie-1.jpg" alt="my image" /><br /><br />
                                    <Card.Text>Pandemia koronawirusa zaskoczyła wszystkich. Rynki zaczęły gwałtownie reagować, a tym samym kursy walut pognały dynamicznie w górę. W pewnym momencie mówiło się o koronakryzysie, co jest prawdą, ponieważ skutki gospodarcze będziemy jeszcze odczuwać przez kolejne lata. Reakcja banków centralnych wspomogła nastroje, jednak ostatecznie gospodarka nadal nie wróciła na dawne tory. Nadal odczuwany jest spadek konsumpcji oraz większa liczba bezrobotnych. Jaki wpływ miało to na notowania walut w ostatnim czasie? Wybierz opcję Waluty z paska nawigacyjnego aby dowiedzieć się więcej.</Card.Text>
                                </Card.Body>
                            </Card>
                        </Col>

                        <Col>
                            <Card >
                                <Card.Img src="https://bitcoin.pl/wp-content/uploads/2020/06/kryptowaluty.jpg" alt="my image" />
                                <Card.Body>
                                    <Card.Text>To nie jest łatwy okres dla osób inwestujących w kryptowaluty, a w Bitcoina w szczególności. Wybuch pandemii koronawirusa i późniejszy halving doprowadziły do sporych zawirowań na rynku BTC, który sam z siebie jest uznawany za mało stabilny. Wybierz opcję Kryptowaluty z paska nawigacyjnego aby dowiedzieć się więcej.</Card.Text>
                                </Card.Body>
                            </Card>
                        </Col>

                        <Col>
                            <Card >
                                <Card.Img src="https://www.jobs-acrosstheworld.com/wp-content/uploads/2019/10/Moncton-immigration-strategy-has-allowed-it-to-gain-more-than-double-the-skilled-foreign-workers-53.png" alt="my image" />
                                <Card.Body>
                                    <Card.Text>Jednym z obecnie największych problemów w Stanach Zjednoczonych jest tzw. wielka rezygnacja z pracy. W trakcie pandemii Amerykanie bez względu na wiek i zawód rzucają zatrudnienie, tworząc luki na rynku pracy. Wybierz opcję USA z paska nawigacyjnego aby dowiedzieć się więcej.</Card.Text>
                                </Card.Body>
                            </Card>
                        </Col>
                        <Stack>
                            <Button onClick={this.Logout} color="error" size="large" type="submit" variant="contained">
                                Wyloguj
                            </Button>
                        </Stack>
                    </Row>

                }
                {
                    this.state.token === null &&
                    <Row xs={1} md={2} className="justify-content-md-center">
                        <Col>
                            <Card className="center">
                                <Card.Img variant="top" src="https://bissole.pl/wp-content/uploads/2020/07/connection-4884862_1280-e1596107781700-800x400.jpg" alt="new" />
                                <Card.Body>
                                    <Card.Text>Kiedy dekadę temu gospodarka światowa podnosiła się po wielkim kryzysie finansowym, wielu ekonomistów uznało ten moment za przełomowy w powojennej historii gospodarczej. Mimo że jeszcze za wcześnie na podsumowania, jest oczywiste, iż podobnie przełomowy okaże się czas pandemii COVID-19. Aby dowiedzieć się więcej na ten temat klikni przycisk poniżej.</Card.Text>
                                    <Stack spacing={2} direction="row">
                                        <Button onClick={this.Authorization} color="success" size="large" type="submit" variant="contained">
                                            Autoryzuj
                                        </Button>
                                    </Stack>
                                </Card.Body>
                            </Card>

                        </Col>
                    </Row>
                }

            </>
        );
    }
    Authorization() {
        const params = new URLSearchParams()
        params.append('username', 'username');
        params.append('password', 'password');
        const headers = {
            'content-type': 'application/x-www-form-urlencoded' ,
          };
          axios.post(`http://localhost:8080/auth/login`,params,{headers})
      .then(res => {
        const token = res.data.accessToken;
        localStorage.setItem("token",token);
        window.location.reload();
      })

    }
    Logout() {
        localStorage.clear();
        window.location.reload();
    }
}
