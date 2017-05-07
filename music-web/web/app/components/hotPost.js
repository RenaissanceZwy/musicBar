/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table,Button,Tag } from 'antd';
let SeparateLine = require('./separateLine.js');
var Styles = require('../css/components/hotPost.css');
import PostUser from '../img/post-user.jpg';

var HotPost = React.createClass({

    render : function () {
        return (
            <Layout style={{backgroundColor:'white'}}>
                <SeparateLine title="热门动态" subtitle="POPULAR POST"/>
                <Row>
                    <Col span="20" offset="2" >
                        <Row className="post-table">
                            <Col span="4">
                                <h1>欧美</h1>
                                <p>2017-04-18</p>
                            </Col>
                            <Col span="4">
                                <img src={PostUser}/>
                            </Col>
                            <Col span="8">
                                <h2>赵文奕</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur a
                                    Lorem ipsum dolor sit amet, consectetur a
                                </p>
                            </Col>
                            <Col span="4">
                                <Tag color="#2db7f5">欧美控</Tag>
                                <Tag color="#2db7f5">电子</Tag>
                            </Col>
                            <Col span="4">
                                <Button type="primary">查看详情</Button>
                            </Col>
                        </Row>
                        <Row className="post-table">
                            <Col span="4">
                                <h1>欧美</h1>
                                <p>2017-04-18</p>
                            </Col>
                            <Col span="4">
                                <img src={PostUser}/>
                            </Col>
                            <Col span="8">
                                <h2>赵文奕</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur a
                                    Lorem ipsum dolor sit amet, consectetur a
                                </p>
                            </Col>
                            <Col span="4">
                                <Tag color="#2db7f5">欧美控</Tag>
                                <Tag color="#2db7f5">电子</Tag>
                            </Col>
                            <Col span="4">
                                <Button type="primary">查看详情</Button>
                            </Col>
                        </Row>
                        <Row className="post-table">
                            <Col span="4">
                                <h1>欧美</h1>
                                <p>2017-04-18</p>
                            </Col>
                            <Col span="4">
                                <img src={PostUser}/>
                            </Col>
                            <Col span="8">
                                <h2>赵文奕</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur a
                                    Lorem ipsum dolor sit amet, consectetur a
                                </p>
                            </Col>
                            <Col span="4">
                                <Tag color="#2db7f5">欧美控</Tag>
                                <Tag color="#2db7f5">电子</Tag>
                            </Col>
                            <Col span="4">
                                <Button type="primary">查看详情</Button>
                            </Col>
                        </Row>
                    </Col>
                </Row>
                <center>
                    <Button style={{width:'200px',marginTop:'25px'}}>加载更多</Button>
                </center>
            </Layout>
        );
    }
});

module.exports = HotPost;