/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table } from 'antd';
let SeparateLine = require('./separateLine.js');
var Styles = require('../css/components/recommendate.css');
import playPng from '../img/play.png';

var RecomBlock = React.createClass({

    render : function () {
        const columns = [{
            title: '歌曲',
            dataIndex: 'music',
            key: 'music',
            render: text => <a href="#">{text}</a>,
        }, {
            title: '歌手',
            dataIndex: 'singer',
            key: 'singer',
        }, {
            title: '专辑',
            dataIndex: 'album',
            key: 'album',
        }, {
            title: '时长',
            dataIndex: 'length',
            key: 'length',
        }, {
            title: '播放',
            key: 'action',
            render: (text, record) => (
                <span><img src={playPng}/></span>
            )
        }];

        const data = [{
            key: '1',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 32,
        }, {
            key: '2',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 42,
        }, {
            key: '3',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 32,
        }, {
            key: '4',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 42,
        }, {
            key: '5',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 32,
        },  {
            key: '6',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 32,
        },  {
            key: '7',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 42,
        }, {
            key: '8',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 32,
        },  {
            key: '9',
            music:'selfish',
            singer: 'John Brown',
            album: 'selfish',
            length: 32,
        }];

        return (
            <div>
                <SeparateLine title='今日推荐' subtitle="recommendations for today"/>
                <Layout>
                    <Row className="rec-row">
                        <Col span="4" offset="2">
                            <Card title="星期三">
                                <h1>25</h1>
                            </Card>
                            <div className="rec-title">
                                <p>美好的一天,</p>
                                <p>&nbsp;&nbsp;&nbsp;&nbsp;从一首美妙的音乐开始</p>
                            </div>
                        </Col>
                        <Col span="16">
                            <div className="rec-table">
                                <Table columns={columns} dataSource={data} pagination={false} />
                            </div>
                        </Col>
                    </Row>
                </Layout>
            </div>
        );
    }
});

module.exports = RecomBlock;