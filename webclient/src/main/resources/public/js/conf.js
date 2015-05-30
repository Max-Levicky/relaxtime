var CONF = {
    cleanUrl: 'localhost:8080'
};
CONF.baseUrl = 'http://' + CONF.cleanUrl + '/';
CONF.apiUrl = CONF.baseUrl + 'api/';
CONF.authUrl = CONF.baseUrl +'auth/';
CONF.wsUrl = 'ws://localhost:9081/hello';
//CONF.wsUrl = 'ws://' + CONF.cleanUrl + '/ws/info';