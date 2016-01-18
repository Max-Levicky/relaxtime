var CONF = {
    cleanApiUrl: 'localhost:8080',
    baseUrl: 'http://localhost:8081'
};
CONF.baseApiUrl = 'http://' + CONF.cleanApiUrl + '/';
CONF.apiUrl = CONF.baseApiUrl + 'api/';
CONF.authUrl = CONF.baseApiUrl +'auth/';
//CONF.wsUrl = 'ws://localhost:9081/hello';
CONF.wsUrl = CONF.baseApiUrl + 'ws';