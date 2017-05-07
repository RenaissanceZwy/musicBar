/**
 * Created by zeng on 2016/5/9.
 */
let React = require('react');
let ReactDOM = require('react-dom');
let TopBar = require('./components/header.js');
let FootBar = require('./components/footer.js');
let CarouselBar = require('./components/carousel.js');
let RecomBlock = require('./components/recommendate.js');
let RecomUser = require('./components/recomUser.js');
let RankBlock = require('./components/rank.js');
let HotSinger = require('./components/hotSinger.js');
let HotAlbum = require('./components/hotAlbum.js');
let HotPost = require('./components/hotPost.js');
import 'antd/dist/antd.css';

ReactDOM.render(<TopBar />, document.getElementById('header'));
ReactDOM.render(<CarouselBar />, document.getElementById('carousel'));
ReactDOM.render(<RecomBlock />, document.getElementById('recomBlock'));
ReactDOM.render(<RecomUser />, document.getElementById('recomUser'));
ReactDOM.render(<RankBlock />, document.getElementById('rankBlock'));
ReactDOM.render(<HotSinger />, document.getElementById('hotSinger'));
ReactDOM.render(<HotAlbum />, document.getElementById('hotAlbum'));
ReactDOM.render(<HotPost />, document.getElementById('hotPost'));
ReactDOM.render(<FootBar />, document.getElementById('footer')); 