/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon  } from 'antd';
import line from '../img/separate-line-b.png';

var SeparateLine = React.createClass({
    render : function () {
        return (
            <div style={{textAlign:'center',marginTop:'50px',marginBottom:'15px'}}>
                <p style={{fontSize:'20px'}}>{this.props.title}</p>
                <img src={line} alt="" style={{margin:'15px'}}/>
                <p style={{fontSize:'10px'}}>{this.props.subtitle}</p>
            </div>
        );
    }
});

module.exports = SeparateLine;