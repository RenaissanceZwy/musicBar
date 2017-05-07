/**
 * Created by Administrator on 2017/5/4.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon  } from 'antd';
const { Header, Footer, Sider, Content } = Layout;
const Search = Input.Search;
import userPng from '../img/user.png';

var TopBar = React.createClass({
    render : function () {
        return (
            <div>
                <Layout>
                    <Header style={{backgroundColor: 'white'}}>
                        <Row>
                            <Col span="2" offset="2">
                                <h3>Renaissance</h3>
                            </Col>
                            <Col span="10" offset="2">
                                <Menu
                                    theme="white"
                                    mode="horizontal"
                                    defaultSelectedKeys={['1']}
                                    style={{ lineHeight: '60px',fontSize: '16px',border: 'none' }}
                                >
                                    <Menu.Item key="1">首页</Menu.Item>
                                    <Menu.Item key="2">排行榜</Menu.Item>
                                    <Menu.Item key="3">歌手</Menu.Item>
                                    <Menu.Item key="4">歌单</Menu.Item>
                                    <Menu.Item key="5">音乐圈</Menu.Item>
                                    <Menu.Item key="6">关于我们</Menu.Item>
                                </Menu>
                            </Col>
                            <Col span="4">
                                <Search
                                    placeholder="troye sivan"
                                />
                            </Col>
                            <Col span="2" offset="2" >
                                <img src={userPng} style={{width:'35px',height:'35px',verticalAlign:'middle'}} />
                            </Col>
                        </Row>
                    </Header>
                </Layout>
            </div>
        );
    }
});

module.exports = TopBar;