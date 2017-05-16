/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table,Button } from 'antd';
var Styles = require('../css/components/hotSinger.css');
let SeparateLine = require('./separateLine.js');
import Singer1 from '../img/singer-1.jpg';
import Singer2 from '../img/singer2.jpg';
import Singer3 from '../img/singer-3.jpg';


var HotSinger = React.createClass({

    render : function () {
        return (
            <Layout style={{backgroundColor:'white'}}>
               <SeparateLine title="热门歌手" subtitle="POPULAR SINGER" />
                <Row className="singer-list">
                    <Col span="6" offset="2">
                        <img src={Singer1} alt=""/>
                        <h1>薛之谦</h1>
                        <Button>查看详情</Button>
                    </Col>
                    <Col span="6" offset="1">
                        <img src={Singer2} alt=""/>
                        <h1>吴亦凡</h1>
                        <Button>查看详情</Button>
                    </Col>
                    <Col span="6" offset="1">
                        <img src={Singer3} alt=""/>
                        <h1>林俊杰</h1>
                        <Button>查看详情</Button>
                    </Col>
                </Row>
            </Layout>
        );
    }
});

module.exports = HotSinger;