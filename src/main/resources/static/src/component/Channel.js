import React from 'react'


export default class Channel extends React.Component {
    render() {
        return (
            <div>
                <div>
                    {this.props.channel.name}
                </div>
                <div>
                    {this.props.channel.description}
                </div>
            </div>

        )
    }
}