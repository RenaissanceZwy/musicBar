/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table,Button } from 'antd';
var Styles = require('../css/components/hotAlbum.css');
let SeparateLine = require('./separateLine.js');
import BgImg from '../img/carousel_2.jpg';
import Album1 from '../img/300.jpg';
import Album2 from '../img/301.png';
import Album3 from '../img/302.jpg';
import Album4 from '../img/304.jpg';


var HotAlbum = React.createClass({

    render : function () {
        return (
            <Layout className="hot-album-body">
                <SeparateLine title="热门歌单" subtitle="POPULAR ALBUM" />
                <Row className="hot-album">
                    <Col span="6" offset="2">
                        <div className="box-outer">
                            <div className="box-inner">
                                <h1>热门歌单</h1>
                                <h3>POPULAR ALBUM</h3>
                                <hr/>
                                <p>
                                    Lorem ipsum dolor sit amet, ridiculus mus. Nam fermentum,
                                    nulla luctus pharetra vulputate, felis tellus mollis orci,
                                    sed rhoncus sapien nunc eget.
                                </p>
                            </div>
                        </div>
                    </Col>
                    <Col span="12">
                        <Row>
                            <Col span="12">
                                <img src={Album1} alt=""/>
                            </Col>
                            <Col span="12">
                                <img src={Album2} alt=""/>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="12">
                                <img src={Album3} alt=""/>
                            </Col>
                            <Col span="12">
                                <img src={Album4} alt=""/>
                            </Col>
                        </Row>
                    </Col>
                </Row>
            </Layout>
        );
    }
});

module.exports = HotAlbum;