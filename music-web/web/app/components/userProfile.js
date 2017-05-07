/**
 * Created by Administrator on 2017/5/7.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon  } from 'antd';
const { Header, Footer, Sider, Content } = Layout;
var Styles = require('../css/components/userInfo.css');

var UserProfile = React.createClass({
    render : function () {
        return (
           <Layout className="userProfile">
               <Row>
                   <Col></Col>
               </Row>
           </Layout>
        );
    }
});

module.exports = UserProfile;
