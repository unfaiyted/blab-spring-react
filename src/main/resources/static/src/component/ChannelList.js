import React from 'react';
import Channel from './Channel'

export default class ChannelList extends React.Component {
    render () {

        let channels = this.props.channels.map(channel =>
        <Channel key={channel._links.self.href} channel={channel} />
        );

        return (
            <div>
                {channels}
            </div>
        )
    }
}