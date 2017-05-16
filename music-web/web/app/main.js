/**
 * Created by zeng on 2016/5/9.
 */
import React from 'react';
import ReactDom from 'react-dom';
import {Router,Route,IndexRoute,Link,hashHistory } from 'react-router';
import Home from './container/Home.js';
import Index from './page/index.js';
import UserInfo from './page/UserInfo.js';
import Collection from './container/collection.js';
import Favorite from './container/favortite.js';
import MusicCircle from './container/musicCircle.js';
import About from './container/about.js';

import 'antd/dist/antd.css';

ReactDom.render((
    <Router history={hashHistory}>
        <Route path="/" component={Index}>
            <IndexRoute component={Home} /> 
            <Route path="user" component={UserInfo}>
                <IndexRoute component={Collection} />
                <Route path="favorite" component={Favorite} />
            </Route>
            <Route path="circle" component={MusicCircle}></Route>
            <Route path="about" component={About}></Route>
        </Route>
    </Router>
),document.getElementById('text')); 