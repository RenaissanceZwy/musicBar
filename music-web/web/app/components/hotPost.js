/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table,Button,Tag } from 'antd';
let SeparateLine = require('./separateLine.js');
var Styles = require('../css/components/hotPost.css');
import PostUser from '../img/post-user.jpg';
import $ from 'jquery';
import {Router,Route,IndexRoute,Link,hashHistory } from 'react-router';

var HotPost = React.createClass({
    getInitialState : function () {
        return {
            postings:[]
        };
    },
    componentWillMount : function (e) {
        var that = this;
        $.ajax({
            url: "http://localhost:8084/music/posting/all",
            type: 'post',
            dataType: 'JSON',
            xhrFields: {
                withCredentials: true
            },
            success: function (data) {
                if(data.code == 201){
                    alert(data.message);
                } else {
                    that.setState({postings:data.object});
                }
            }
        });
    },
    render : function () {
        var items = this.state.postings;
        return (
            <Layout style={{backgroundColor:'white'}}>
                <SeparateLine title="热门动态" subtitle="POPULAR POST"/>
                <Row>
                    <Col span="20" offset="2" >
                        {
                            items.map(function (item) {
                                var labels = item.label.split("_");
                                return (
                                    <Row className="post-table">
                                        <Col span="4">
                                            <h1>欧美</h1>
                                            <p>{item.createtime}</p>
                                        </Col>
                                        <Col span="4">
                                            <img src={PostUser}/>
                                        </Col>
                                        <Col span="8">
                                            <h2>{item.username}</h2>
                                            <p>{item.content}
                                            </p>
                                        </Col>
                                        <Col span="4">
                                            
                                                {
                                                    labels.map(function (item) {
                                                        if(item != ""){
                                                            return <Tag color="#108ee9">{item}</Tag>
                                                        }
                                                    })
                                                }

                                        </Col>
                                        <Col span="4">
                                            <Button type="primary">查看详情</Button>
                                        </Col>
                                    </Row>
                                )
                            })
                        }
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