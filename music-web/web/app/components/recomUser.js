/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table,Button } from 'antd';
import userJpg from '../img/user.jpg';
var Styles = require('../css/components/recomUser.css');

var RecomUser = React.createClass({
    render : function () {
        return (
            <div>
                <Layout>
                    <Row style={{backgroundColor:'white'}}>
                        <Col span="6" offset="2" >
                            <div className="user-info">
                                <h1>吴亦凡</h1>
                                <center><hr/></center>
                                <p>简介</p>
                                <p>或是好字画，书籍卷册，轻巧顽意儿，
                                    给我带些来。</p>
                                <Button>不感兴趣</Button>
                                <Button type="primary">感兴趣</Button>
                            </div>
                        </Col>
                        <Col span="8" className="user-avatar">
                            <img src={userJpg}  />
                        </Col>
                        <Col span="6">
                            <div className="user-cmn">
                                <h1>吴亦凡</h1>
                                <center><hr/></center>
                                <ul>
                                    <li>> 累计听歌    233  首</li>
                                    <li>> 你们共同喜欢 《小幸运》 </li>
                                    <li>> 你们共同收藏 《Rihanna》 </li>
                                    <li>> 你们共同评论 《你就不要想起我》 </li>
                                </ul>
                                <Button type="primary">发送消息</Button>
                            </div>
                        </Col>
                    </Row>
                </Layout>
            </div>
        );
    }
});

module.exports = RecomUser;